default:
	lein deps
	lein test
	lein install
	lein jar

run:
	# java -jar lm-complete-0.1.0-standalone.jar
	java -jar target/lm-complete-0.1.0-SNAPSHOT.jar