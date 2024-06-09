DOCKER_IMAGES = $(shell docker images -q policy-webapp)

up:
	docker-compose up --build --remove-orphans

down:
ifneq ($(strip $(DOCKER_IMAGES)),)
	docker-compose down -v --remove-orphans
	docker rmi $(DOCKER_IMAGES)
endif

.PHONY: up down
