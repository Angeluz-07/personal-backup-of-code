-module(bmi).
-export([compute/1]).

%assumes weight in kg, and height in meters
compute({Weight,Height}) ->
	BMI = Weight / (Height * Height),
	categorize(BMI).

categorize(BMI) when BMI < 18.5 ->
	{underweight,BMI};
categorize(BMI) when BMI >= 18.5, BMI =< 24.9 ->
	{normal,BMI};
categorize(BMI) when BMI >= 25, BMI =< 29.9 ->
	{overweight,BMI};
categorize(BMI) when BMI >= 30 ->
	{obese,BMI}.

	
