var socket = new SockJS('/ws');
var stompClient = Stomp.over(socket);
stompClient.connect({}, function (frame) {
    console.log('Connected: ' + frame);
    stompClient.subscribe('/topic/public', function (message) {
        var chatMessage = JSON.parse(message.body);
        var ulist = document.getElementById("msg_list");
        var litem = document.createElement("li");
        litem.setAttribute("id", "msg_cnt");
        litem.appendChild(document.createTextNode(chatMessage.message));
        ulist.appendChild(litem);
    });
});
document.querySelector('#chatForm').addEventListener('submit', function (event) {
    event.preventDefault();
    var messageInput = document.querySelector('#messageInput');
    var chatMessage = {
        sender: "Me",
        message: messageInput.value,
        timestamp: new Date()
    };
    stompClient.send('/app/chat', {}, JSON.stringify(chatMessage));
    messageInput.value = '';
});
