#!/usr/bin/env bash
# Copyright 2019 Mia srl
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

versions=$(grep -oP '(?<=version>)[^<]+' "pom.xml")
completeVersion="${versions[0]%*}"
currentRc="$(cut -d'-' -f2 <<<"${completeVersion}")"

projectVersion="${versions[0]%-*}"
currentMajor="$(cut -d'.' -f1 <<<"${projectVersion}")"
currentMinor="$(cut -d'.' -f2 <<<"${projectVersion}")"
currentPatch="$(cut -d'.' -f3 <<<"${projectVersion}")"

case $2 in
rc)
    rc="-rc"
    ;;
*)
    rc=""
esac


case $1 in
major)
    nextMajor=$((currentMajor+1))
    nextMinor=0
    nextPatch=0
    newVersion="${nextMajor}.${nextMinor}.${nextPatch}${rc}"
    ;;
minor)
    nextMajor=${currentMajor}
    nextMinor=$((currentMinor+1))
    nextPatch=0
    newVersion="${nextMajor}.${nextMinor}.${nextPatch}${rc}"
    ;;
patch)
    nextMajor=${currentMajor}
    nextMinor=${currentMinor}
    nextPatch=$((currentPatch+1))
    newVersion="${nextMajor}.${nextMinor}.${nextPatch}${rc}"
    ;;
promote)
    if [ "${currentRc}" == "rc" ] ; then
        newVersion="${currentMajor}.${currentMinor}.${currentPatch}"
    else
        echo "you are trying to promote a not rc version"
        exit 1
    fi
    ;;
*)
    echo "please choose allowed option"
    echo "example: ./tag.sh [major|minor|patch|promote] [rc]"
    exit 1
    ;;
esac


while true; do
    echo "${versions[0]} >>> ${newVersion}"
    read -rp "Confirm tag? (y) " answer


    if [[ $answer =~ ^[Yy]$ ]] ;
    then
        mvn versions:set -DnewVersion="${newVersion}"
        git add pom.xml
        git commit -m "${newVersion}"
        git tag "v${newVersion}"
        echo "tag ready to be pushed"
    else
        echo "nothing happened"
    fi

    break
done
