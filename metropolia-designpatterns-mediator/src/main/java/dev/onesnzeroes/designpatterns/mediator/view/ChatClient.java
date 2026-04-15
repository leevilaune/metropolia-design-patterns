package dev.onesnzeroes.designpatterns.mediator.view;

import dev.onesnzeroes.designpatterns.mediator.controller.ChatController;
import dev.onesnzeroes.designpatterns.mediator.model.Message;
import dev.onesnzeroes.designpatterns.mediator.model.MessageService;
import dev.onesnzeroes.designpatterns.mediator.model.User;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.time.Instant;
import java.util.UUID;

public class ChatClient extends Application {

    private ListView<Message> chatView;
    private ObservableList<Message> chatItems;

    private TextField messageField;
    private ComboBox<User> recipientBox;
    private Button sendButton;

    private String name;
    private ChatController controller;

    public ChatClient() {
        this.name = "root";
    }

    public ChatClient(String name) {
        this.name = name;
    }

    @Override
    public void start(Stage stage) {

        this.controller = MessageService.getInstance().createController(this.name);
        this.controller.setChatClient(this);

        Button setUsernameButton = new Button("Refresh");
        setUsernameButton.setOnAction(e -> refresh());

        chatItems = FXCollections.observableArrayList();
        chatView = new ListView<>(chatItems);
        chatView.setCellFactory(list -> new ListCell<>() {

            private final Tooltip tooltip = new Tooltip();

            @Override
            protected void updateItem(Message msg, boolean empty) {
                super.updateItem(msg, empty);

                if (empty || msg == null) {
                    setText(null);
                    setTooltip(null);
                } else {
                    setText(controller.getUsername(msg.getSenderId()) + " -> " + controller.getUsername(msg.getReceiverId()) +":\n    "+ msg.getContent());

                    tooltip.setText("Sent at: " + msg.getTs());
                    setTooltip(tooltip);
                }
            }
        });

        messageField = new TextField();
        messageField.setPromptText("Type your message...");

        recipientBox = new ComboBox<>();
        recipientBox.getItems().addAll(controller.getUsers());
        recipientBox.setPromptText("Select recipient");

        sendButton = new Button("Send");

        sendButton.setOnAction(e -> {
            String content = messageField.getText();
            User recipient = recipientBox.getValue();

            if (content.isEmpty() || recipient == null) {
                return;
            }

            Message message = new Message(recipient.getUserId(),
                    this.controller.getUser().getUserId(),
                    content,
                    Instant.now());

            chatItems.add(message);

            this.controller.sendMessage(message);
            messageField.clear();
        });

        Button newWindowButton = new Button("New Chat Window");
        newWindowButton.setOnAction(e -> startNewInstance());

        HBox inputRow = new HBox(10, recipientBox, messageField, sendButton, newWindowButton);
        inputRow.setPadding(new Insets(10));
        HBox.setHgrow(messageField, Priority.ALWAYS);

        HBox setUsernameRow = new HBox(10, setUsernameButton);

        VBox root = new VBox(10, chatView, inputRow);
        root.setPadding(new Insets(10));
        VBox.setVgrow(chatView, Priority.ALWAYS);

        Scene scene = new Scene(root, 500, 400);
        stage.setTitle(this.name);
        stage.setScene(scene);
        stage.show();
    }

    private void startNewInstance() {
        Stage stage = new Stage();
        try {
            String randomName = UUID.randomUUID().toString().substring(0, 8);
            new ChatClient(randomName).start(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void refresh() {
        this.recipientBox.setItems(
                FXCollections.observableArrayList(controller.getUsers())
        );
    }

    public void receiveMessage(Message message) {
        chatItems.add(message);
        refresh();
    }
}