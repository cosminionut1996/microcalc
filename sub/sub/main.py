from flask import Flask, abort, jsonify, request
import waitress


app = Flask(__name__)

@app.route('/', methods=['POST'])
def sub():
    if request.method == 'POST':
        if not request.json:
            abort(400, message="Arguments are not passed as json data")
        if 'x' not in request.json:
            abort(400, message="No x value")
        if 'y' not in request.json:
            abort(400, message="No y value")
        if len(request.json) > 2:
            abort(400, message="Too many arguments")
        for param in ['x', 'y']:
            if not isinstance(request.json.get(param), int):
                abort(400, message="Invalid parameter type: %s is not int" % param)
    else:
        abort(404, "Metod %s not allowed" % request.method)
    return jsonify({
        'result': request.json['x'] - request.json['y']
    })

def server():
    waitress.serve(app, port=80)
