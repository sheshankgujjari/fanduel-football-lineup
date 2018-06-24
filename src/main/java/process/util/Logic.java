package process.util;

import process.model.LineUp;
import process.model.Player;

import java.util.ArrayList;
import java.util.List;

public class Logic {

    public static void buildLineUp(List<Player> players) {
        List<Player> quarterBackPlayers = Parser.getListofPlayers(players, "QB");
        List<Player> runningBackPlayers = Parser.getListofPlayers(players, "RB");
        List<Player> wideReceiverPlayers = Parser.getListofPlayers(players, "WR");
        List<Player> tePlayers = Parser.getListofPlayers(players, "TE");
        List<Player> kickerPlayers = Parser.getListofPlayers(players, "K");
        List<Player> defencePlayers = Parser.getListofPlayers(players, "D");

        List<String> lineUpList = new ArrayList<>();
        for (int i = 0; i < quarterBackPlayers.size(); i++) {
            for (int j = 0; j < runningBackPlayers.size(); j++) {
                for (int k = 0; k < wideReceiverPlayers.size(); k++) {
                    for (int l = 0; l < tePlayers.size(); l++) {
                        for (int m = 0; m < kickerPlayers.size(); m++) {
                            for (int n = 0; n < kickerPlayers.size(); n++) {
                                lineUpList.add(
                                        Parser.constructLineUp(quarterBackPlayers.get(i).getPosition(),
                                                quarterBackPlayers.get(i).getTeam(),
                                                quarterBackPlayers.get(i).getFirstName(),
                                                quarterBackPlayers.get(i).getLastName(),
                                                quarterBackPlayers.get(i).getSalary())+ "||||" +
                                         Parser.constructLineUp(runningBackPlayers.get(j).getPosition(),
                                                runningBackPlayers.get(j).getTeam(),
                                                runningBackPlayers.get(j).getFirstName(),
                                                runningBackPlayers.get(j).getLastName(),
                                                runningBackPlayers.get(j).getSalary()) + "||||" +
                                        Parser.constructLineUp(wideReceiverPlayers.get(k).getPosition(),
                                                wideReceiverPlayers.get(k).getTeam(),
                                                wideReceiverPlayers.get(k).getFirstName(),
                                                wideReceiverPlayers.get(k).getLastName(),
                                                wideReceiverPlayers.get(k).getSalary()) + "||||" +
                                        Parser.constructLineUp(tePlayers.get(l).getPosition(),
                                                tePlayers.get(l).getTeam(),
                                                tePlayers.get(l).getFirstName(),
                                                tePlayers.get(l).getLastName(),
                                                tePlayers.get(l).getSalary()) + "||||"+
                                        Parser.constructLineUp(kickerPlayers.get(m).getPosition(),
                                                kickerPlayers.get(m).getTeam(),
                                                kickerPlayers.get(m).getFirstName(),
                                                kickerPlayers.get(m).getLastName(),
                                                kickerPlayers.get(m).getSalary()) + "||||" +
                                        Parser.constructLineUp(defencePlayers.get(n).getPosition(),
                                                defencePlayers.get(n).getTeam(),
                                                defencePlayers.get(n).getFirstName(),
                                                defencePlayers.get(n).getLastName(),
                                                defencePlayers.get(n).getSalary()));
                            }
                        }
                    }
                }
            }
        }
        for (String lineUp: lineUpList) {
            System.out.println(lineUp.toString());
        }
    }

    public static void wrAndRb(List<Player> players) {
        List<Player> runningBackPlayers = Parser.getListofPlayers(players, "RB");
        List<Player> wideReceiverPlayers = Parser.getListofPlayers(players, "WR");

        LineUp lineUp = new LineUp();
        List<LineUp> lineUpList = new ArrayList<>();
        for (int i = 0; i < runningBackPlayers.size(); i++) {

            int temp = i;
            //play.add(runningBackPlayers.get(temp));
            lineUp.setRunningBackOne(runningBackPlayers.get(temp).getFirstName());
            if(temp + 1 < runningBackPlayers.size()) {
                //play.add(runningBackPlayers.get(temp + 1));
                lineUp.setRunningBackTwo(runningBackPlayers.get(temp + 1).getFirstName());
            }
            for(int j=0; j< wideReceiverPlayers.size(); j++) {
                int tempWide = j;
                //play.add(wideReceiverPlayers.get(tempWide));
                lineUp.setWideReceiverOne(wideReceiverPlayers.get(tempWide).getFirstName());
                tempWide = tempWide + 1;
                if(tempWide <  wideReceiverPlayers.size()) {
                    //play.add(wideReceiverPlayers.get(tempWide));
                    lineUp.setWideReceiverTwo(wideReceiverPlayers.get(tempWide).getFirstName());
                }
                if(tempWide+ 1 <  wideReceiverPlayers.size()) {
                    //play.add(wideReceiverPlayers.get(tempWide+ 1));
                    lineUp.setWideReceiverThree(wideReceiverPlayers.get(tempWide + 1).getFirstName());
                }
                //tempWide = 0;
                lineUpList.add(lineUp);
                lineUp = new LineUp();
            }

        }
        for (LineUp player : lineUpList) {
            System.out.println(player.getRunningBackOne() + " " +
                    player.getRunningBackTwo() + " " + player.getWideReceiverOne() + " "
                   + player.getWideReceiverTwo() + " " + player.getWideReceiverThree());
            System.out.println("\n");
        }

    }
}

