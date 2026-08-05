import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

class Twitter {
    HashMap<Integer, HashSet<Integer>> following;
    HashMap<Integer, List<int[]>> tweets;
    int time;

    public Twitter() {
        following = new HashMap<>();
        tweets = new HashMap<>();
        time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!tweets.containsKey(userId)) tweets.put(userId, new ArrayList<>());

        tweets.get(userId).add(new int[]{tweetId, ++time});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        // Inserting own feed;
        if(tweets.containsKey(userId)) {
            for(int[] tweet: tweets.get(userId)) {
                pq.add(tweet);
                if(pq.size() > 10) pq.poll();
            }
        }

        // Insert following's feed
        if(following.containsKey(userId)) {
            for(int followee: following.get(userId)) {
                if(tweets.containsKey(followee)) {
                    for(int[] tweet: tweets.get(followee)) {
                        pq.add(tweet);
                        if(pq.size() > 10) pq.poll();
                    }
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        while (!pq.isEmpty()) {
            ans.add(pq.poll()[0]);
        }

        Collections.reverse(ans);
        return ans; 
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId == followeeId) return;

        if(!following.containsKey(followerId)) following.put(followerId, new HashSet<>());

        following.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followerId == followeeId || !following.containsKey(followerId)) return;
        following.get(followerId).remove(followeeId);
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

public class DesignTwitter {
    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5); // User 1 posts a new tweet (id = 5).

        for(int i: twitter.getNewsFeed(1)) {
            System.out.print(i + " ");
        } // User 1's news feed should return a list with 1 tweet id -> [5]. return [5]

        System.out.println();

        twitter.follow(1, 2);    // User 1 follows user 2.
        twitter.postTweet(2, 6); // User 2 posts a new tweet (id = 6).

        for(int i: twitter.getNewsFeed(1)) {
            System.out.print(i + " ");
        }// User 1's news feed should return a list with 2 tweet ids -> [6, 5]. Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
        System.out.println();

        twitter.unfollow(1, 2);  // User 1 unfollows user 2.

        for(int i: twitter.getNewsFeed(1)) {
            System.out.print(i + " ");
        }// User 1's news feed should return a list with 1 tweet id -> [5], since user 1 is no longer following user 2. 
    }
}