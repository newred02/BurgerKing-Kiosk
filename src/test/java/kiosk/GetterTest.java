package kiosk;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Scanner;

class GetterTest {

    @Test
    void 예외처리_잘못된_메뉴번호입력() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    systemIn("7");
                    Getter.getMenuNumber();
                });

    }

    @Test
    void 예외처리_잘못된_수량입력() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    systemIn("51");
                    Getter.getUserInput();
                });

    }

    protected void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

}