package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private final Exception exception = new Exception();

    /**
     * 다리의 길이를 입력받는다.
     */
    public String readBridgeSize() {
        return Console.readLine();
    }

    public int setBridgeSize() {
        String bridgeSize = readBridgeSize();
        int bridge = 0;
        try {
            bridge = checkException(bridgeSize);
            return bridge;
        } catch (NullPointerException NPE) {
            System.out.println("[ERROR] 값을 입력해주세요");
        } catch (NumberFormatException NFE) {
            System.out.println("[ERROR] 숫자만 입력해주세요");
        } catch (IllegalArgumentException IAE) {
            System.out.println("[ERROR] 3 이상 20 이하의 값을 입력해주세요");
        }
        return 0;
    }

    public int checkException(String bridgeSize) {
        if (exception.isEmpty(bridgeSize)) {
            throw new NullPointerException("NPE");
        }
        if (!exception.isNumber(bridgeSize)) {
            throw new NumberFormatException("NFE");
        }
        if (exception.isRangeInThreeAndTwenty(Integer.parseInt(bridgeSize))) {
            throw new IllegalArgumentException("IAE");
        }
        return Integer.parseInt(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return Console.readLine();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
