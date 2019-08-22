from setuptools import find_packages, setup

setup(
    name='sub',
    version='0.1',
    install_requires=[
        'Flask',
        'waitress'
    ],
    entry_points={
        'console_scripts': [
            "calc_sub_server=sub.main:server",
        ],
    },
    packages=find_packages()
)
