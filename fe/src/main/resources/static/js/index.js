
(function() {
  "use strict";

  // Shortcut to get elements
  var el = function(element) {
    if (element.charAt(0) === "#") { // If passed an ID...
      return document.querySelector(element); // ... returns single element
    }

    return document.querySelectorAll(element); // Otherwise, returns a nodelist
  };

  // Variables
  var viewer = el("#viewer"), // Calculator screen where result is displayed
    equals = el("#equals"), // Equal button
    nums = el(".num"), // List of numbers
    ops = el(".ops"), // List of operators
    theNum = "", // Current number
    oldNum = "", // First number
    resultNum, // Result
    operator, // Batman
    address = "http://localhost:80/";

  // When: Number is clicked. Get the current number selected
  var setNum = function() {
    if (resultNum) { // If a result was displayed, reset number
      theNum = this.getAttribute("data-num");
      resultNum = "";
    } else { // Otherwise, add digit to previous number (this is a string!)
      theNum += this.getAttribute("data-num");
    }

    viewer.innerHTML = theNum; // Display current number

  };

  // When: Operator is clicked. Pass number to oldNum and save operator
  var moveNum = function() {
    oldNum = theNum;
    theNum = "";
    operator = this.getAttribute("data-ops");

    equals.setAttribute("data-result", ""); // Reset result in attr
  };

  // When: Equals is clicked. Calculate result
  var displayNum = function() {

    // Convert string input to numbers
    oldNum = parseFloat(oldNum);
    theNum = parseFloat(theNum);

    // Perform operation
//    switch (operator) {
//      case "add":
//        resultNum = oldNum + theNum;
//        break;
//
//      case "sub":
//        resultNum = oldNum - theNum;
//        break;
//
//      case "mul":
//        resultNum = oldNum * theNum;
//        break;
//
//      case "div":
//        resultNum = Math.floor(oldNum / theNum);
//        break;
//
//        // If equal is pressed without an operator, keep number and continue
//      default:
//        resultNum = theNum;
//    }

    var payload = createPayload(oldNum, theNum);
    resultNum = getResult(payload, operator);

    // If NaN or Infinity returned
    if (!isFinite(resultNum)) {
      if (isNaN(resultNum)) { // If result is not a number; set off by, eg, double-clicking operators
        resultNum = "You broke it!";
      } else { // If result is infinity, set off by dividing by zero
        resultNum = "Impartit la 0???";
        //el('#calculator').classList.add("broken"); // Break calculator
        //el('#reset').classList.add("show"); // And show reset button
      }
    }

    // Display result, finally!
    viewer.innerHTML = resultNum;
    equals.setAttribute("data-result", resultNum);

    // Now reset oldNum & keep result
    oldNum = 0;
    theNum = resultNum;

  };

  // When: Clear button is pressed. Clear everything
  var clearAll = function() {
    oldNum = "";
    theNum = "";
    viewer.innerHTML = "0";
    equals.setAttribute("data-result", resultNum);
  };

  /* The click events */

  // Add click event to numbers
  for (var i = 0, l = nums.length; i < l; i++) {
    nums[i].onclick = setNum;
  }

  // Add click event to operators
  for (var i = 0, l = ops.length; i < l; i++) {
    ops[i].onclick = moveNum;
  }

  // Add click event to equal sign
  equals.onclick = displayNum;

  // Add click event to clear button
  el("#clear").onclick = clearAll;

  // Add click event to reset button
  el("#reset").onclick = function() {
    window.location = window.location;
  };

  function createPayload(x, y){
    return JSON.stringify({"x": x, "y": y});
  }

  function getResult(payload, operation){
    var url = address + operation;
    var result;

    $.ajax({
      type: "POST",
      url: url,
      async: false,
      data: payload,
       headers: {'Accept': 'application/json',
                 'Content-Type': 'application/json',
                 'Access-Control-Allow-Origin': '*'
                      },
      success: function(response){
        console.log("Success:" + response['result']);
        result = response['result']
      },
      error: function(response){
        console.log("Error: " + response);
        result = "Esti but rau!"
      }
    });

    return result;
  }

}());