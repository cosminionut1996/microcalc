FROM python:3-alpine3.10

COPY add /root/add
COPY setup.py /root

RUN python -m venv /root/env

RUN /root/env/bin/pip install --upgrade pip
RUN /root/env/bin/pip install -e /root

CMD ["/root/env/bin/calc_add_server"]
