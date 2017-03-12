import random
import string

from django.http import HttpResponse
from django.shortcuts import render


# Create your views here.
from django.views.decorators.csrf import csrf_exempt

from heuristic_server.models import LoginRequest


def index(request):
    return render(request, "heuristic_server/index.html", {})


@csrf_exempt
def login_req(request):
    if request.method == "POST":
        login_req_obj = LoginRequest.objects.create(id=request.POST["requestid"])
        login_req_obj.save()

        return HttpResponse("Ok")


@csrf_exempt
def request_id(request):
    return HttpResponse(''.join(random.SystemRandom().choice(string.ascii_uppercase + string.digits) for _ in range(10)))
