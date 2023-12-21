-module(heartRate).
-export([max/1,target/1]).

max(Age) ->
	220 - Age.

%returns target heart rate {lowerBound,upperBound}
target(Age) ->
	{0.5 * max(Age) , 0.8 * max(Age)}.
