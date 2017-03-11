from django.conf.urls import include, url
from django.http import HttpResponseRedirect

from heuristic_server import views

urlpatterns = [
    url(r'^$', lambda r: HttpResponseRedirect('index')),
    url(r'^index/$', views.index, name='index'),

]