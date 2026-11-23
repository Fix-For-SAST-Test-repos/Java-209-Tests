# VeraDemo Java - CWE-209 Edition

## Overview
This is a **VeraDemo Java-based framework** retrofitted with **CWE-209 (Information Exposure Through an Error Message)** test cases. This repository combines the Spring Boot-based VeraDemo framework structure with focused CWE-209 vulnerability demonstrations.

## Purpose
- Execute CWE-209 vulnerability tests within the VeraDemo framework
- Support GitHub pipeline execution
- Provide a clean, maintainable test harness for CWE-209 scanning
- Eliminate unnecessary .java files that cause framework conflicts

## Repository Structure

```
verademo-java-cwe209/
├── app/
│   ├── pom.xml                                 # Maven config (CWE-209 optimized)
│   ├── src/main/java/
│   │   ├── StackTraceServlet_Test01.java      # Jakarta - Stack trace exposure
│   │   ├── AuthServlet_Test02.java            # Jakarta - Security exception
│   │   ├── JsonServlet_Test03.java            # Jakarta - JSON parse error
│   │   ├── StackTraceServlet_Test04.java      # Javax - Division by zero
│   │   └── SystemPropertyServlet_Test05.java  # Javax - Runtime exception
│   └── src/main/resources/
├── .github/workflows/                          # GitHub Actions CI/CD
├── Dockerfile
├── Jenkinsfile
├── pom.xml                                     # Root pom.xml
├── README.md
├── VERSION
├── VERSION
└── [CI/CD configs: azure-pipelines.yml, bitbucket-pipelines.yml, etc.]
```

## Key Differences from Original VeraDemo

✅ **Clean Java Source Tree** - Only CWE-209 test classes in `/app/src/main/java/`
✅ **No package structure** - Classes at root of java/ directory (flattened for simplicity)
✅ **CWE-209 specific dependencies** - pom.xml optimized for test requirements
✅ **Framework compatibility** - Maintains VeraDemo build structure for pipeline execution
✅ **Minimal bloat** - Removed unnecessary verademo classes that caused conflicts

## CWE-209 Test Cases

| Test | File | Servlet API | Vulnerability |
|------|------|-------------|---|
| 01 | StackTraceServlet_Test01.java | Jakarta | Stack trace exposure via exception |
| 02 | AuthServlet_Test02.java | Jakarta | Security exception message exposure |
| 03 | JsonServlet_Test03.java | Jakarta | JSON parsing error message exposure |
| 04 | StackTraceServlet_Test04.java | Javax | Stack trace from division by zero |
| 05 | SystemPropertyServlet_Test05.java | Javax | Runtime exception message exposure |

## Building

### Compile
```bash
cd app
mvn clean compile
```

### Package
```bash
cd app
mvn clean package
```

### Full Build (with root pom)
```bash
mvn clean package
```

## GitHub Pipeline

The repository includes GitHub Actions workflow configuration in `.github/workflows/`. The pipeline:
1. ✅ Compiles CWE-209 test classes
2. ✅ Runs Maven verify
3. ✅ Generates WAR artifact

## Veracode Scanning

Scan with Veracode CLI:
```bash
# Using app subdirectory
veracode_QA_patch package \
  --source app \
  --type directory

# Or scan the full repository
veracode_QA_patch package \
  --source . \
  --type directory
```

Expected detection: **5 HIGH severity CWE-209 flaws** (one per test class)

## Dependencies

The optimized `pom.xml` includes:
- **Servlet APIs:** javax.servlet + jakarta.servlet
- **SLF4J** (1.7.36) - Logging
- **Jackson** (2.17.0) - JSON parsing
- **Spring Web** (5.3.39) - Utilities
- **Spring Boot** (2.3.1) - Framework base

Removed:
- VeraDemo application classes
- Database configuration
- Complex Spring components
- Unnecessary utility classes

## Troubleshooting

### "Class file has wrong version"
✅ **Solution:** pom.xml now specifies Java 11 source/target

### "Cannot find com.veracode packages"
✅ **Solution:** Removed references - not needed for CWE-209 tests

### Pipeline build failures
✅ **Solution:** Clean pom.xml with only required dependencies

## Conversion Details

**Original:** java-cwe209-combined test suite
**Adapted to:** VeraDemo Java framework structure
**Result:** Hybrid repo that works in both standalone and pipeline contexts

### What Was Removed
- `/app/src/main/java/com/` package structure
- All VeraDemo application classes
- Unnecessary Spring components
- Database-related dependencies
- SAML, Keycloak, MySQL driver support

### What Was Kept
- `/app/` subdirectory structure
- Spring Boot framework foundation
- Maven multi-module layout
- GitHub Actions workflow support
- Dockerfile and deployment configs

## Migration Path

If migrating other test suites to VeraDemo framework:
1. Copy `verademo-java-cwe209` as template
2. Replace test files in `/app/src/main/java/`
3. Update `pom.xml` with required dependencies
4. Test locally: `mvn clean compile`
5. Push and verify GitHub pipeline passes

## Next Steps

- Run pipeline build to verify setup
- Execute Veracode scan on generated WAR
- Validate all 5 CWE-209 flaws are detected
- Use as reference template for other CWE conversions

---

**Framework:** VeraDemo Java (Spring Boot 2.3.1)  
**CWE Focus:** CWE-209 (Information Exposure Through an Error Message)  
**Status:** Ready for GitHub pipeline execution
