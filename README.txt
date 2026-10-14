LandMatch - separated folders

frontend/templates/
  Copies of the existing HTML pages (index.html, lands.html, add-land.html).
  These files are unchanged. They are kept here for the requested frontend folder.

backend/
  The complete Spring Boot project source, including the original templates under
  src/main/resources/templates. The original templates remain in place so the
  existing Spring Boot + Thymeleaf app can continue serving the pages.

Important:
  This is a folder separation for source organization, not a conversion to a
  standalone frontend framework. The HTML pages use the Spring Boot backend and
  Thymeleaf, so keep the copies in backend/src/main/resources/templates for the
  app to work as it did before. No Java, HTML, Maven, or configuration source
  files were edited. Generated target/ output and .git metadata were omitted.
