const express = require('express')
const app = express()
var port = process.env.PORT || 3000;

app.use(express.static('dist/movies-front'));

app.listen(port, function () {
  console.log('Started on port ' + port)
})
