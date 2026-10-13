# test-03

Test repository for dependency and CVE scanning. It reproduces the third-party dependency set of a
real product repository that depends on `test-01` (Maven libraries and BOM) and `test-02` (web UI).

- root - imports `test-01-bom`, like the real root imports the library BOM.
- `test-03-bom` - copy of the real BOM with only the third-party entries, importing `test-01-bom`.
- `test-03-parent` - imports `test-03-bom`, like the real sub-parents do.
- `test-03-api`, `test-03-integrations`, `test-03-messaging`, `test-03-persistence`,
  `test-03-reporting`, `test-03-security` - every BOM entry is declared by exactly one module and
  each module depends on `test-01` modules, so their libraries arrive transitively.
- `test-03-webapp` - WAR bundling all modules and libraries in `WEB-INF/lib`, with the `test-02`
  dist archives unpacked into it.

Version `25.4.10-SNAPSHOT`. `test-01` and `test-02` must be deployed first:

```
mvn clean deploy
```
