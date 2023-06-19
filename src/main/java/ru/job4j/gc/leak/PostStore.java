package ru.job4j.gc.leak;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class PostStore {

    private Map<Integer, Post> posts = new HashMap<>();
    private int count = 0;

    public Post add(Post post) {
        int id = count + 1;
        count = id;
        post.setId(id);
        posts.put(id, post);
        return post;
    }

    public void removeAll() {
        posts.clear();
    }

    public Collection<Post> getPosts() {
        return posts.values();
    }
}