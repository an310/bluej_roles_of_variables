/*
 * Created on 20-Jun-2005
 */
package main.rules;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * @author cbishop
 */
public class Gatherer extends RoleChecker {

    /**
     * Constructor for Gatherer
     * 
     * @param analysedMap
     *            LinkedHashMap of analysed statements
     * @param variable
     *            String being variable name
     * @param methods
     *            ArrayList of method names
     */
    public Gatherer(LinkedHashMap analysedMap, String variable,
    ArrayList methods, LinkedHashMap currentMap) {
        super(analysedMap, variable, methods, currentMap);
    }

    /**
     * Return list of result from role check
     * 
     * @return ArrayList
     */
    public ArrayList checkRole() {
        ArrayList results = gatherer();
        //System.out.println(results);
        if (!isGatherer()) {
            if (isFixedValue()) {
                results.add(resultStringer.fixedValue());
            } else if (isOrganizer()) {
                results.add(resultStringer.organizer());
            } else if (isStepper()) {
                results.add(resultStringer.stepper());
            } else if (isMostRecentHolder()) {
                results.add(resultStringer.mostRecentHolder());
            } else if (isMostWantedHolder()) {
                results.add(resultStringer.mostWantedHolder());
            } else if (isOneWayFlag()) {
                results.add(resultStringer.oneWayFlag());
            } else if (isFollower()) {
                results.add(resultStringer.follower());
            } else if (isTemporary()) {
                results.add(resultStringer.temporary());
            } else if (isContainer()) {
                results.add(resultStringer.container());
            } else if (isWalker()) {
                results.add(resultStringer.walker());
            } else {
                results.add(resultStringer.other());
            }
        }
        return results;
    }
}

/*
 * debug rules for gatherer
 * 
 * if (!onBothSidesOfAssign && !indirectBS) { result = false;
 * results.add(debugStringer.bothSides(onBothSides, false)); } if (isArray &&
 * isReorganize) { result = false;
 * results.add(debugStringer.isOrganizer(reorganize)); } if (toggleStatement) {
 * result = false; results.add(debugStringer.toggle(toggleStatements)); } if
 * (incDecStatement) { result = false;
 * results.add(debugStringer.incDec(incDecStatements)); } results.add(0, new
 * Boolean(result)); return results;
 */