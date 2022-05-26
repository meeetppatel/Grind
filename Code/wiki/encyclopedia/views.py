from distutils.log import error
from turtle import title
from django.shortcuts import redirect, render
from queue import PriorityQueue
from django.http import HttpResponse
from django.http import HttpResponseRedirect
from django import forms

from django.http import HttpResponseRedirect
from django.shortcuts import render
from django.urls import reverse
from markdown2 import markdown
from random import randint

from . import util


class NewTaskForm(forms.Form):
    entry = forms.CharField(label="New Entries")


def index(request):
    return render(request, "encyclopedia/index.html", {
        "entries": util.list_entries()
    })


def entry(request, title):
    content = util.get_entry(title.strip())
    if content == None:
        content = "# Page was not found"
    content = markdown(content)
    return render(request, "encyclopedia/entry.html", {
        'content': content, 'title': title
    })


# def search(request):
#     q = request.GET.get('q').strip()
    
#     if q in util.list_entries():
#         return redirect("entry", title=q)
#     return render(request, "encyclopedia/search.html", {
#         "entries": util.search(q), 'q': q
#     })
def search(request):
    input_string = request.GET.get('q')
    matching_entries = []

    for entry in util.list_entries():
        if input_string.lower() in entry.lower():
            matching_entries.append(entry)
        
    if len(matching_entries) != 0:
        return render(request,"encyclopedia/search.html",{"entries":matching_entries, "value":input_string})
    else:
        return render(request,"encyclopedia/search.html",{"title":input_string})


def create(request):
    if request.method == "POST":
        title = request.POST.get("title").strip()
        content = request.POST.get("content").strip()

        if title == "" or content == "":
            return render(request, "encyclopedia/create.html", {
                {"message": "can't save with empty field",
                 "title": title, "content": content}
            })
        if title in util.list_entries():
            return render(request, "encyclopedia/create.html", {
                {"message": "title already exist, Try another.",
                 "title": title, "content": content}
            })
        util.save_entry(title, content)
        return redirect("entry", title=title)
    return render(request, "encyclopedia/create.html")

def edit(request, title):
    content = util.get_entry(title.strip())
    if content == None:
        return render(request, "encyclopedia/edit.html", {'error': "404 Not Found"})

    if request.method == "POST":
        content = request.POST.get("content").strip()
        if content == "":
            return render(request, "encyclopedia/edit.html", {"message": "Can't save with empty field.", "title": title, "content": content})
        util.save_entry(title, content)
        return redirect("entry", title=title)
    return render(request, "encyclopedia/edit.html", {'content': content, 'title': title})


def random(request):
    entries = util.list_entries()
    random_entry = entries[randint(0, len(entries)-1)]
    return redirect("entry", title=random_entry)