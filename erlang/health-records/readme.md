# Computerization of Health Records
Minimal implementation of computerization of health records in Erlang.

## Usage
### Setting environment
1. Open a terminal and place in project's directory
2. Compile with `make`
3. Start erlang shell `erl`

### Functions
- `bmi:compute({Weight,Height}).`
- `heartRate:max(Age).` 
- `heartRate:target(Age).`
-  `HP1 = #healthProfile{firstName="Bob",lastName="Lee",age=23,height=1.7,weight=75}.`

### Examples
bmi:compute() expects units in Kg and meters.
```
>> bmi:compute({75,1.7}).
{overweight,25.95155709342561}
```
units of heartRate:max() are beats per minute.
```
>> heartRate:max(20).
200
>> heartRate:target(20).
{100.0,160.0}
```

```
>>rr("healthRecord.hrl").
>>#healthProfile{age=23,height=1.7,weight=75}.
#healthProfile{firstName = undefined,lastName = undefined, age = 23,height = 1.7,weight = 75}
```

### References
  * Implementation was done based on info from exercises 2.33, 3.16 and 3.17 from [Java How to Program - Deitel](http://www.deitel.com/Books/Java/JavaHowtoProgram10eEarlyObjects/tabid/3656/Default.aspx)
  * This is merely an example, don't rely on these formulas for any health program.
  
