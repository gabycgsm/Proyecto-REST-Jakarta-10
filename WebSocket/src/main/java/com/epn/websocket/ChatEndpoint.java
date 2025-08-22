/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.epn.websocket;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 *
 * @author ricardo
 */

@ServerEndpoint("/chat")   // URL del WebSocket -> ws://localhost:8080/tuApp/chat
public class ChatEndpoint {

    private static final Set<Session> clients = new CopyOnWriteArraySet<>();

    @OnOpen
    public void onOpen(Session session) {
        clients.add(session);
        System.out.println("Cliente conectado: " + session.getId());
    }

    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        System.out.println("Mensaje recibido: " + message);
        // reenviar a todos los clientes conectados (broadcast)
        for (Session client : clients) {
            if (client.isOpen()) {
                client.getBasicRemote().sendText("Cliente " + session.getId() + ": " + message);
            }
        }
    }

    @OnClose
    public void onClose(Session session) {
        clients.remove(session);
        System.out.println("Cliente desconectado: " + session.getId());
    }
    
    
    public static void sendNotification(String message) {
        synchronized (clients) {
            for (Session session : clients) {
                try {
                    session.getBasicRemote().sendText(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
}