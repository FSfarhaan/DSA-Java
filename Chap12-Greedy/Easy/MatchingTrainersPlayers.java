import java.util.Arrays;

public class MatchingTrainersPlayers {

    static int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);

        int left = 0, right = 0;
        int n = players.length, m = trainers.length;

        while (left < n && right < m) {
            if(trainers[right] >= players[left]) {
                left++;
            }

            right++;
        }

        return left;
    }

    public static void main(String[] args) {
        int[] players = {4,7,9}, trainers = {8,2,5,8};
        System.out.println(matchPlayersAndTrainers(players, trainers));

    }
}
