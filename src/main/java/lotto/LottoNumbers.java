package lotto;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.rangeClosed;

public class LottoNumbers {
    private static final int MIN = 1;
    private static final int MAX = 45;
    private static final List<Integer> NUMBERS = rangeClosed(MIN, MAX).boxed().collect(toList());

    private final List<Integer> values;

    public LottoNumbers() {
        this.values = lottoNumbers();
    }

    public LottoNumbers(List<Integer> values) {
        this.values = values;
    }

    private List<Integer> lottoNumbers() {
        Collections.shuffle(NUMBERS);

        return NUMBERS.stream()
                .limit(6)
                .sorted()
                .collect(toList());
    }

    public List<Integer> getValues() {
        return values;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(values, that.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }

    @Override
    public String toString() {
        return "LottoNumbers{" +
                "values=" + values +
                '}';
    }
}
