<h1 align="center">Backend проект с использованием микросервисной архитектуры</h1>

<a name="summary">
  <details>
    <summary>Оглавление</summary>
    <ol>
      <li><a href="#project-description">Описание проекта</a></li>
      <li><a href="#project-installation">Эксплуатация проекта</a></li>
      <li><a href="#project-functionality">Функциональность проекта</a></li>
      <li><a href="#project-future">Планы по улчушению проекта</a></li>
    </ol>
  </details>
</a>

<a name="project-description"><h2>1. Описание проекта</h2></a>
Пет проект, предствляющий из себя API для создания опросов/викторин по различным темам. В корневой папке проекта есть пример таблицы с вопросами. Проект создан при помощи Spring boot MVC, Microservices (Eureka, Feign), PostgreSQL и так далее.  
<br>

<a name="project-installation"><h2>2. Эксплуатация проекта</h2></a>

1. git clone https://github.com/WoobotGJR/quizappMicroservice - клонировать репозиторий
2. Запустить сервер с API с помощью Apache Tomcat 

<a name="project-functionality"><h2>3. Функциональность проекта</h2></a>

- CRUD операции с вопросами для викторины и самой викториной
- Создание викторины из запрашиваемого количества вопросов на запрашиваемую тематику 
- Возврат результатов викторины (количество правильных ответов)

<a name="project-future"><h2>4. Планы по улучшению проекта</h2></a>

- Добавление пользователей (Spring security, JWT)
- Нормальная настройка Swagger
- Добавление логгирования при помощи Spring AOP

