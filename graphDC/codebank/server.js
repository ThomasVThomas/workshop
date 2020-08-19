// modules =================================================
var express        = require('express');
var app            = express();
var mongoose       = require('mongoose');
var bodyParser     = require('body-parser');
var methodOverride = require('method-override');
var http 		   = require('http').createServer(app);

var io 			   = require('socket.io')(http);

// configuration ===========================================
	
// config files
var port = process.env.PORT || 8080; // set our port
var db = require('./config/db');

// connect to our mongoDB database (commented out after you enter in your own credentials)
connectionsubject = mongoose.createConnection(db.urlSubjectViews);

var Subjects = connectionsubject.model('', {}, 'projects');

function loadData() {
	console.log("in fun call");
	app.get('/api/data', function(req, res) {
		
    Subjects.find({}, {'_id': 0, 'school_state': 1, 'resource_type': 1, 'poverty_level': 1, 'date_posted': 1, 'total_donations': 1, 'funding_status': 1, 'grade_level': 1}, function(err, subjectDetails) {
   if (err) 
	res.send(err);
   res.json(subjectDetails); 
   console.log(subjectDetails+"...........");
  });
 });

 // frontend routes =========================================================
 app.get('*', function(req, res) {
  res.sendfile('./public/login.html');
 });
}


function refreshData(){
	Subjects.find({}, {'_id': 0, 'school_state': 1, 'resource_type': 1, 'poverty_level': 1, 'date_posted': 1, 'total_donations': 1, 'funding_status': 1, 'grade_level': 1}, function(err, subjectDetails) {
   if (err){console.log(err+" : error");}
   io.emit('message', JSON.stringify(subjectDetails));
	console.log (subjectDetails);
  });
}
// get all data/stuff of the body (POST) parameters
app.use(bodyParser.json()); // parse application/json 
app.use(bodyParser.json({ type: 'application/vnd.api+json' })); // parse application/vnd.api+json as json
app.use(bodyParser.urlencoded({ extended: true })); // parse application/x-www-form-urlencoded

app.use(methodOverride('X-HTTP-Method-Override')); // override with the X-HTTP-Method-Override header in the request. simulate DELETE/PUT
app.use(express.static(__dirname + '/public')); // set the static files location /public/img will be /img for users

loadData();
// start app ===============================================
http.listen(port);	
console.log('Application started on ' + port); 			// shoutout to the user
exports = module.exports = http; 						// expose app

setInterval( function() {
refreshData();
  
  }, 10000);
