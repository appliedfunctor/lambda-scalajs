require("event-collector-lambda-fastopt.js");

function makeLambda(scalaCallObject) {
    return function(event, context) {
        try {
            var msg = scalaCallObject.apply(event, context);
            context.done(null, msg);
        } catch (err) {
            context.done(err.toString(), null);
        }
    };
}

exports.handler = makeLambda(com.ajsworton.EventCollectorLambda.handler());