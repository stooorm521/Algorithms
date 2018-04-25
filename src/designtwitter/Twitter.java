package designtwitter;

import java.util.ArrayList;
import java.util.List;

public class Twitter {
    //时间戳
    private static int timeStamp = 0;

    //Tweet link to next tweet so that we can save lots of time;
    //when we excute getNewsFeed(userID)
    private class Tweet {
    public int id;
    public int time;
    public Tweet next;

    public Tweet(int id){
        this.id=id;
        time=timeStamp++;
        next=null;
    }
    }
//OO design
    /**
     * Initialize your data structure here.
     */
    public Twitter() {

    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {

    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
return new ArrayList<>();
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {

    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {

    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */

