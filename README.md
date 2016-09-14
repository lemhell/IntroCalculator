# IntroCalculator

This is a simple calculator, which parses input string and evaluates it.


## Changelog:

### 0.3.0 (14.09.16)

 * Added Serializable interface, serialization of the AST
 * Pretty printing of the serialized AST in the terminal
 * Small bugfixes

### 0.2.0 (12.09.16)

 * Added Evaluator, which tries to evaluate the expression, parsed by parser
 * Added Result class, which holds either float, or boolean
 * Added EvaluationException
 * Reading of the expression from the terminal

### 0.1.0 (03.09.16)

 * Added parser, which tries to build an AST from input string
 * Added ParseException