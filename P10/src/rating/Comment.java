package P10.src.rating;

import P10.src.people.Person;

import java.util.ArrayList;

public class Comment {
    private String text;
    private Person author;
    private Comment inReplyTo;
    private ArrayList<Comment> replies;

    public Comment(String text, Person author, Comment inReplyTo) {
        if (text == null || author == null || text.isEmpty()) {
            throw new IllegalArgumentException("text and author cant be null");
        }

        this.text = text;
        this.author = author;
        this.inReplyTo = inReplyTo;
        this.replies = new ArrayList<>();
    }

    public void addReply(String text, Person author){
        if(text == null || author == null || text.isEmpty()) {
            throw new IllegalArgumentException("text and author cant be null");
        }

        Comment comment = new Comment(text, author, this);
        replies.add(comment);
    }

    public int numReplies() {
        return replies.size();
    }

    public Comment getReply(int index){
        return replies.get(index);
    }

    public Comment getInReplyTo() {
        return inReplyTo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Comment by ").append(author);

        if( inReplyTo != null ) {
            sb.append(", in reply to ").append(inReplyTo.author);
        }

        if(!replies.isEmpty()) {
            sb.append("\n");
            int i = 0;
            for(Comment comment : replies) {
                sb.append(i++).append(" ").append(comment.author).append("\n");
            }
        }

        return sb.toString();
    }
}