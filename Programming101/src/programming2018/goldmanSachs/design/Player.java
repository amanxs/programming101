package programming2018.goldmanSachs.design;

public class Player {
    private int currentPosition;
    public String playerName;

    public int getCurrentPosition(){
        return currentPosition;
    }

    public void setCurrentPosition(int position){
        currentPosition= position;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        if (currentPosition != player.currentPosition) return false;
        return playerName != null ? playerName.equals(player.playerName) : player.playerName == null;
    }

    @Override
    public int hashCode() {
        int result = currentPosition;
        result = 31 * result + (playerName != null ? playerName.hashCode() : 0);
        return result;
    }
}
