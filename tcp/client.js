const net = require("net");

const PORT = 5000;
const HOST = "localhost";

const server = net.createServer((socket) => {
  console.log("Cliente conectado.");

  socket.on("data", (data) => {
    console.log(`Mensagem recebida do cliente: ${data.toString()}`);
    socket.write("Mensagem recebida pelo servidor!");
  });

  socket.on("close", () => {
    console.log("Cliente desconectado.");
  });

  socket.on("error", (err) => {
    console.error(`Erro no socket: ${err.message}`);
  });
});

server.listen(PORT, HOST, () => {
  console.log(`Servidor escutando em ${HOST}:${PORT}`);
});
