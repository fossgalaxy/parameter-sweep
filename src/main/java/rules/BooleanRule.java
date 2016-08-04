package rules;

/**
 * Created by piers on 04/08/16.
 */
public class BooleanRule {
    private final Double trueProbability;

    public BooleanRule(){
        this(0.5d);
    }

    public BooleanRule(double trueProbability) {
        this.trueProbability = trueProbability;
    }

    public Double getTrueProbability() {
        return trueProbability;
    }
}
