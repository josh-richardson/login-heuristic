from django.db import models


# Create your models here.
class LoginRequest(models.Model):
    id = models.CharField(unique=True, primary_key=True)
    mouseData = models.CharField(unique=True)
    keyboardData = models.CharField(unique=True)

    def __str(self):
        return self.id

    # @classmethod
    # def create(cls, title):
    #     logreq = cls(title=title)
    #     # do something with the book
    #     return logreq
