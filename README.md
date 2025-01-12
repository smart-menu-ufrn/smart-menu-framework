# Smart Menu Framework

## Table of Contents

- [Smart Menu Framework](#smart-menu-framework)
  - [Table of Contents](#table-of-contents)
  - [Framework](#framework)
    - [SmartMenu](#smartmenu)
  - [Instances](#instances)
    - [BookStore](#bookstore)
    - [DrinkStore](#drinkstore)
    - [DrugStore](#drugstore)

## Framework

### SmartMenu

## Instances

### BookStore

```bash
$ docker compose --file docker-compose-bookstore.yaml up
```

```bash
$ gradle bootRun -Pprofile=bookstore -PmainClass=br.edu.ufrn.bookstore.BookStoreApplication
```

### DrinkStore

```bash
$ docker compose --file docker-compose-drinkstore.yaml up
```

```bash
$ gradle bootRun -Pprofile=drinkstore -PmainClass=br.edu.ufrn.drinkstore.DrinkStoreApplication
```

### DrugStore

```bash
$ docker compose --file docker-compose-drugstore.yaml up
```

```bash
$ gradle bootRun -Pprofile=drugstore -PmainClass=br.edu.ufrn.drugstore.DrugStoreApplication
```
