# Java Parameter Sweep Library
By Piers Williams <pwllic@essex.ac.uk>

## Building
```bash
git checkout git@git.fossgalaxy.com:essex/parameter-sweep.git
mvn clean package
```

## Release to central
```bash
mvn -P release deploy
git tag -s v1.5 -m 'v0.1'
```
