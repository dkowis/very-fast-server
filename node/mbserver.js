http = require('http')
Buffer = require('buffer').Buffer;
n = 1024*1024;
b = new Buffer(n);
for (var i = 0; i < n; i++) b[i] = 100;
 
http.createServer(function (req, res) {
  res.writeHead(200);
  res.end(b);
}).listen(8000);
