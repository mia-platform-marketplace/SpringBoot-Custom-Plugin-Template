# mia_template_service_name_placeholder

Welcome to Java SpringBoot template service for Mia-Platform!

## How to develop this service

This example jus expose hello endpoint.

### Run locally

Before running the service on your local machine you need to prepare the required environment variables

```bash
cp default.env local.env
set -a; source local.env
```

To run locally this example just run the following command

```bash
mvn spring-boot:run
```

To change server port

```bash
mvn spring-boot:run -Dspring-boot.run.arguments=--server.port=8000
```

To launch tests locally

```bash
mvn test
```

To build it

```bash
mvn clean package
```

To force mvn package update

```bash
mvn clean install -U
```

# Tag Project

### Tag new project version

Please use the `tag.sh` to update the `pom.xml` project version and commit release to git.

Respect the following syntax to invoke the script:

```shell
    bash tag.sh [options] [rc]
```

According to [semver](https://semver.org/), *options* could be:

* _major_ version when you make incompatible API changes
* _minor_ version when you add functionality in a backwards-compatible manner
* _patch_ version when you make backwards-compatible bug fixes.

According to Mia-Platform release process *rc* could be:

* _rc_ add `-rc` to your release tag
* omitted

### Promote `rc` release

When your service is ready to production you can promote your rc version invoking the scritp with `promote` option.

```shell
    bash tag.sh promote
```

### Push changes

Don't forget to push commit and tag:

```shell
git push
git push --tags
```

### Examples

Assuming your current version is `v1.2.3`

|command   | result  |
|---|---|
|`bash tag.sh major`   |`v2.0.0`   |
|`bash tag.sh minor`   |`v1.3.0`   |
|`bash tag.sh patch`   |`v1.2.4`   |
|`bash tag.sh major rc`   |`v2.0.0-rc`   |
|`bash tag.sh minor rc`   |`v1.3.0-rc`   |
|`bash tag.sh patch rc`   |`v1.2.4-rc`   |

Assuming your current version is `v1.2.3-rc`

|command   | result  |
|---|---|
|`bash tag.sh promote`   |`v1.2.3`|
