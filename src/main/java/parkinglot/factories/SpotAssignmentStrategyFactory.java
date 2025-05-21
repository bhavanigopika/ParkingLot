package parkinglot.factories;

import parkinglot.models.enums.SpotAssignmentStrategyType;
import parkinglot.models.enums.VehicleType;
import parkinglot.strategies.spotAssignmentStrategy.CheapestSpotAssignmentStrategy;
import parkinglot.strategies.spotAssignmentStrategy.NearestToElevatorSpotAssignmentStrategy;
import parkinglot.strategies.spotAssignmentStrategy.RandomSpotAssignmentStrategy;
import parkinglot.strategies.spotAssignmentStrategy.SpotAssignmentStrategy;

public class SpotAssignmentStrategyFactory {
    public static SpotAssignmentStrategy getSpotAssignmentStrategy(SpotAssignmentStrategyType spotAssignmentStrategyType) {
        if(spotAssignmentStrategyType.equals(SpotAssignmentStrategyType.CHEAPEST)){
            return new CheapestSpotAssignmentStrategy();
        }
        else if(spotAssignmentStrategyType.equals(SpotAssignmentStrategyType.RANDOM)){
            return new RandomSpotAssignmentStrategy();
        }
        else if(spotAssignmentStrategyType.equals(SpotAssignmentStrategyType.NEAREST_TO_ELEVATOR)){
            return new NearestToElevatorSpotAssignmentStrategy();
        }
        return null;
    }
}
