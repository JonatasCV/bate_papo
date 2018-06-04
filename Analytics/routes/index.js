var express = require('express');
var router = express.Router();
var request = require('request');

/* GET home page. */
router.get('/', function(req, res, next) {

  res.render('index', { title: 'Express' });
});

router.post('/chats', (req, res) => {

  request.get({
      uri: 'https://batepaporest.herokuapp.com/chats-realizados',
      form: {filter: ''}
    },
    (err, requestRes, body) => {
      res.send(JSON.parse(body));
    });
});

module.exports = router;
