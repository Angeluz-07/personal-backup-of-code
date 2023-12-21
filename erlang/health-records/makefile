ERLC= erlc #erlang compiler
FLAGS= -W -I . # '-I .' looks for headers in current dir

all: bmi.beam heartRate.beam

%.beam: %.erl
	$(ERLC) $(FLAGS) $<

clean:
	rm *.beam
