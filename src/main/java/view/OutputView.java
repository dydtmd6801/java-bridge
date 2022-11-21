package view;

import java.util.HashMap;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String START = "[";
    private static final String END = "]";
    private static final String MIDDLE = "|";

    private HashMap<Integer, Boolean> upBridge = new HashMap<>();
    private HashMap<Integer, Boolean> downBridge = new HashMap<>();

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     *
     * @param endTurn : 마지막 턴에는 "|"를 출력하지 않도록 구분하기위해 사용
     */
    public void printMap(int endTurn) {
        List<HashMap> bridge = List.of(upBridge, downBridge);
        for (HashMap bridgeSelect : bridge) {
            printBridge(endTurn, bridgeSelect);
        }

    }

    private void printBridge(int endTurn, HashMap<Integer, Boolean> bridge) {
        System.out.print(START);
        for (int key : bridge.keySet()) {
            System.out.print(String.format(" %s ", bridge.get(key)));
            if (key + 1 == endTurn) {
                continue;
            }
            System.out.print(MIDDLE);
        }
        System.out.println(END);
    }

    public void store(Boolean match, String move, int turn) {
        if (move.equals("U")) {
            upBridge.put(turn, match);
            downBridge.put(turn, null);
        }
        if (move.equals("D")) {
            upBridge.put(turn, null);
            downBridge.put(turn, match);
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
