package com.example.commentqueueconsumer;

import com.example.commentqueueconsumer.model.Comment;
import com.example.commentqueueconsumer.util.feign.CommentServiceClient;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
//@Component
public class MessageListener {
    @Autowired
    CommentServiceClient client;

    public MessageListener(CommentServiceClient client) {
        this.client = client;
    }

    @RabbitListener(queues = CommentQueueConsumerApplication.QUEUE_NAME)
    public void receiveMessage(Comment message){
        if (message.getCommentId()==0){
            client.addComment(message);
        } else {
            client.updateComment(message.getCommentId(), message);
        }
    }
}
