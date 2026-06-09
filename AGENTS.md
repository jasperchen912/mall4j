# Repository Guidelines

## Project Structure & Module Organization

This is a multi-module Maven/Spring Boot 4 shop application. Backend modules live at the repository root: `yami-shop-admin` for admin APIs, `yami-shop-api` for customer APIs, `yami-shop-service` for business services and MyBatis XML, `yami-shop-bean` for DTO/model objects, `yami-shop-common` for shared utilities, `yami-shop-sys` for system features, and `yami-shop-security` for auth. Java source is under each module's `src/main/java`; resources and profiles are under `src/main/resources`.

Frontend projects are under `front-end/`: `mall4v` is the Vue 3 admin UI, `mall4uni` is the uni-app client, and `mall4m` is the mini-program client. Database setup lives in `db/yami_shop.sql`; docs are in `doc/`.

## Build, Test, and Development Commands

- `mvn clean package`: builds all backend modules and runnable Spring Boot jars.
- `mvn -pl yami-shop-admin -am spring-boot:run`: runs the admin service.
- `mvn -pl yami-shop-api -am spring-boot:run`: runs the customer API service.
- `mvn test`: runs backend tests when present.
- `docker compose up --build`: starts MySQL, Redis, admin, and API containers.
- `cd front-end/mall4v && pnpm install && pnpm dev`: runs the admin UI.
- `cd front-end/mall4uni && pnpm install && pnpm dev:h5`: runs the H5 client.

## Coding Style & Naming Conventions

Use Java 17, UTF-8, and the existing `com.yami.shop.*` package layout. Keep controllers in `controller`, services in service modules, and MyBatis XML in `yami-shop-service/src/main/resources/mapper`. Follow current four-space Java indentation and Vue Standard ESLint style. Java classes use `PascalCase`; methods, fields, and Vue variables use `camelCase`; mapper XML names should match their domain names, such as `ProductMapper.xml`.

## Testing Guidelines

Add backend tests under the affected module's `src/test/java` path and name them `*Test` or `*Tests`. Prefer focused service and controller tests, especially around order, payment, auth, and mapper logic. Run `mvn test` before submitting backend changes. For front-end changes, run `pnpm lint` in `mall4v` or `mall4uni`; add manual verification notes when automated tests are absent.

## Commit & Pull Request Guidelines

Recent history uses short, direct summaries, often in Chinese, such as `移除无用配置` or `升级springboot4,jackson3...`. Keep commits concise and scoped to one change. Pull requests should describe the change, list affected modules, mention database/configuration changes, link issues, and include screenshots for UI updates. Note the commands you ran.

## Security & Configuration Tips

Do not commit secrets, production credentials, or local overrides. Use the existing Spring profiles in `application-dev.yml`, `application-prod.yml`, and `application-docker.yml`. Keep schema changes synchronized with `db/yami_shop.sql` and document any migration steps in the PR.
