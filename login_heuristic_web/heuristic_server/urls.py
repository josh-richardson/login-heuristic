from django.conf.urls import include, url
from django.http import HttpResponseRedirect

from heuristic_server import views

urlpatterns = [
    url(r'^$', lambda r: HttpResponseRedirect('index')),
    url(r'^index/$', views.index, name='index'),
    url(r'^loginreq/$', views.login_req, name='loginreq'),
    url(r'^requestid/$', views.request_id, name='requestid')

]