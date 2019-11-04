branch=$master

if [ -z "$branch" ]; then
		branch="forge_1.12.2"
fi

rm -rf ./UniversalModCore

git clone --branch $branch git@github.com:TeamOpenIndustry/UniversalModCore.git

./UniversalModCore/template/setup.sh $branch lmc LearningModCore 0.0.1 landofrails.lmc.LearningModCore

./gradlew clean
./gradlew cleanIdea
./gradlew cleanIdeaWorkspace
./gradlew setupDevWorkspace
./gradlew classes
./gradlew idea
./gradlew genIntellijRuns