from setuptools import find_packages, setup

setup(
    name='div',
    version='0.1',
    install_requires=[
        'Flask',
        'waitress'
    ],
    entry_points={
        'console_scripts': [
            "calc_div_server=div.main:server",
        ],
    },
    packages=find_packages()
)
