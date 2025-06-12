const net = require('net');

const PORT = 5000;
const HOST = 'localhost';

const server = net.createServer((socket) => {

    console.log(`Conexão aceita do end. ${socket.remoteAddress}:${socket.remotePort}`);
    socket.on('data', (data) => {
        console.log(`Mensagem: ${data.toString()}`);
        socket.write('Mensagem recebida !');
    });

    socket.on('end', () => {
        console.log('Cliente desconectado.');
    });
});

server.listen(PORT, HOST, () => {
    console.log('Servidor rodando...');
    console.log(`Escutando em ${HOST}:${PORT}`);
});