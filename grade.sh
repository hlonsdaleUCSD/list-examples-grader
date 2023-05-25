CPATH='.:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar'

rm -rf student-submission
rm -rf grading-area

mkdir grading-area

git clone -q $1 student-submission
echo 'Finished cloning'


# Draw a picture/take notes on the directory structure that's set up after
# getting to this point

# Then, add here code to compile and run, and do any post-processing of the
# tests

if [[ -f student-submission/ListExamples.java ]]
    then
        echo "ListExamples file found!"
    else 
        echo "error: File ListExamples not found!"
        exit
    fi

cp student-submission/ListExamples.java grading-area
cp TestListExamples.java grading-area
if [[ -f grading-area/ListExamples.java ]] && [[ -f grading-area/TestListExamples.java ]]
    then
        echo "Files moved into grading area!"
    else
        echo "error moving files into grading area!"
    fi
javac -cp $CPATH grading-area/*.java 2> grading-area/javacStderr.txt
if [[ -f grading-area/ListExamples.class ]] && [[ -f grading-area/TestListExamples.class ]]
    then
        echo "Java compilation successful!"
    else
        echo "Compile error! Exit code" $?
        cat grading-area/javacStderr.txt
        exit
    fi
cd grading-area
java -cp .:../lib/hamcrest-core-1.3.jar:../lib/junit-4.13.2.jar org.junit.runner.JUnitCore TestListExamples > TestListExampleStdout.txt 2> TestListExampleStderr.txt
cat TestListExampleStdout.txt
grep -i "Tests" TestListExampleStdout.txt > TestsLine.txt
#if [[ TestsLine.txt  == *","* ]]
#    then
#        echo "You failed some tests, try again!"
#	cat TestsLine.txt	
#	exit
#    else if [[ TestListExampleStdOut == *"OK"*  ]]
#    then
#        echo "Congrats! perfect score 3/3" 
#    fi
#fi
