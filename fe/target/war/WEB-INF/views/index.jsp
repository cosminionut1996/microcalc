<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href='https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400' rel='stylesheet' type='text/css'>
        <script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>



    </head>
    <body>
        <h1>JavaScript Calculator</h1>
        <p class="warning">Don't divide by zero</p>

        <div id="calculator" class="calculator">

          <button id="clear" class="clear">C</button>

          <div id="viewer" class="viewer">0</div>

          <button class="num" data-num="7">7</button>
          <button class="num" data-num="8">8</button>
          <button class="num" data-num="9">9</button>
          <button data-ops="add" class="ops">+</button>

          <button class="num" data-num="4">4</button>
          <button class="num" data-num="5">5</button>
          <button class="num" data-num="6">6</button>
          <button data-ops="sub" class="ops">-</button>

          <button class="num" data-num="1">1</button>
          <button class="num" data-num="2">2</button>
          <button class="num" data-num="3">3</button>
          <button data-ops="mul" class="ops">*</button>

          <button class="num" data-num="0">0</button>
          <button class="num" data-num="">.i.</button>
          <button id="equals" class="equals" data-result="">=</button>
          <button data-ops="div" class="ops">/</button>
        </div>

        <button id="reset" class="reset">Reset Universe?</button>

        <link rel="stylesheet" type="text/css" href="/css/index.css">
        <script type="text/javascript" src="/js/index.js"></script>
    </body>
</html>