from setuptools import find_packages, setup

setup(
    name='add',
    version='0.1',
    install_requires=[
        'Flask',
        'waitress'
    ],
    entry_points={
        'console_scripts': [
            "calc_add_server=add.main:server",
        ],
    },
    packages=find_packages()
)
